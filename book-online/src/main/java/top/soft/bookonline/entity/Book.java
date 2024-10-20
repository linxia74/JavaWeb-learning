package top.soft.bookonline.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 23164
 * @description: TODO
 * @date 2024/10/19 16:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;
}
