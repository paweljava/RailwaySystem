package com.railway.station.domain.common;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor(staticName = "of")
public class StationName {

    private final String value;
}
