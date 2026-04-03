package at.htlkaindorf.backend_mwperformence.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: backend_MWPerformence
 * Created by: Dominik Ranegger
 * Date: 02.04.2026
 * Time: 23:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpeningHoursDTO {
    private Long id;
    private String dayLabel;
    private String openTime;
    private String closeTime;
    private Boolean closed;
}
