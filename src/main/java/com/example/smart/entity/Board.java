package com.example.smart.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "BOARD")
@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seqno")
    private int seqno;
    @Column(name = "subject")
    private String subject;//제목
    @Column(name = "content")
    private String content;//본문내용
    @Column(name = "read_cnt")
    private int readCnt;//조회수
    @Column(name = "writer")
    private String writer;//작성자
    @Column(name = "regist_date")
    private LocalDateTime registDate; //작성일


}
