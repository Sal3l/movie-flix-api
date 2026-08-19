package dev.sal3l.movieflixapi.mapper;

import dev.sal3l.movieflixapi.DTO.StreamingRequest;
import dev.sal3l.movieflixapi.DTO.StreamingResponse;
import dev.sal3l.movieflixapi.entity.Streaming;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper {

    public static Streaming map(StreamingRequest request) {
        return Streaming.builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse map(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
