package specialisation.demo.influxdb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Measurement(name = "temperatures", database = "database")
public class MeasurementEntity {
    @Column(name = "time")
    Instant time;
    @Column(name = "type", tag = true)
    String type;
    @Column(name = "measurement")
    Long measurement;
}
