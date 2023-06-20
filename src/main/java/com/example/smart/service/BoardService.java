package com.example.smart.service;

import com.example.smart.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> listBoard(Board board);
    Board oneBoard(Board board);
    int saveBoard(Board board);
    int modifyBoard(Board board);
    int deleteBoard(Board board);
}
