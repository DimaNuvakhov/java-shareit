package ru.practicum.shareit.item;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getText(),
                comment.getItemId(), comment.getAuthorId(), comment.getCreated());
    }

    public static List<CommentDto> toCommentDtoList(List<Comment> comments) {
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            commentDtos.add(toCommentDto(comment));
        }
        return commentDtos;
    }

    public static Comment toComment(CommentDto commentDto) {
        return new Comment(commentDto.getId(), commentDto.getText(),
                commentDto.getItemId(), commentDto.getAuthorId(), commentDto.getCreated());
    }
}
