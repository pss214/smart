package com.example.smart.service;

import com.example.smart.entity.Board;
import com.example.smart.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> listBoard(Board board) {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    @Override
    public Board oneBoard(Board board) {
        Optional<Board> optional = boardRepository.findById(board.getSeqno());
        if (optional.isPresent()) {
            return optional.get();
        }else {
            return null;
        }
    }

    @Override
    public int saveBoard(Board board) {
        boardRepository.save(board);
        return 1;
    }

    @Override
    public int modifyBoard(Board board) {
        Optional<Board> optional = boardRepository.findById(board.getSeqno());
        if (optional.isPresent()){
            Board dto = optional.get();
            dto.setSubject(board.getSubject());
            dto.setContent(board.getContent());
            boardRepository.save(dto);
            return 1;
        }else
            return 0;
    }

    @Override
    public int deleteBoard(Board board) {
        Optional<Board> optional = boardRepository.findById(board.getSeqno());
        if (optional.isPresent()) {
            boardRepository.delete(optional.get());
            return 1;
        }else
            return 0;
    }
}
