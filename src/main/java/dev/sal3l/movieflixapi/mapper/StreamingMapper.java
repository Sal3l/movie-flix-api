package dev.sal3l.movieflixapi.mapper;

import dev.sal3l.movieflixapi.DTO.StreamingRequest;
import dev.sal3l.movieflixapi.DTO.StreamingResponse;
import dev.sal3l.movieflixapi.entity.Streaming;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StreamingMapper {

    Streaming map(StreamingRequest request);

    StreamingResponse map(Streaming streaming);

}
