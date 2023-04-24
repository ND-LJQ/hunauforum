package edu.hunau.entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * 搜索实体
 *
 * @author ND_LJQ
 * @date 2023/04/24
 */
@Data
public class SearchArticleEntity extends ForumArticleWithBLOBs implements Serializable {
    private String keyword;


}
