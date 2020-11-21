package org.zdjavapol12.springcourse.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "hotel.personnel.minions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelPersonnelConfig {

    private List<String> names;
    private Map<String, String> people;
}
