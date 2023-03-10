package specialisation.demo.influxdb;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import specialisation.demo.influxdb.config.InfluxDbConfig;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/measurements")
@ConditionalOnBean(InfluxDbConfig.class)
public class MeasurementController {

    private final InfluxDbRepository<MeasurementEntity> repository;
    private final Clock clock;

    public MeasurementController(InfluxDbRepository<MeasurementEntity> repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    @PostMapping
    ResponseEntity<MeasurementEntity> createMeasurements(
        @RequestBody MeasurementRequest request
    ) {
        var entity = MeasurementEntity.builder()
            .time(Instant.now(clock))
            .chalet(request.chalet())
            .temp(request.temp())
            .build();

        return ResponseEntity.ok(repository.store(entity));
    }

    @GetMapping
    ResponseEntity<List<MeasurementEntity>> retrieveMeasurements(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<OffsetDateTime> start,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<OffsetDateTime> end
    ) {
        return ResponseEntity.ok(repository.fetch(
            start.orElse(OffsetDateTime.now(clock).minusMonths(1)),
            end.orElse(OffsetDateTime.now(clock))
        ));
    }

    @DeleteMapping
    ResponseEntity<Void> deleteMeasurements(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime start,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime end
    ) {
        repository.delete(start, end);
        return ResponseEntity.ok().build();
    }
}
