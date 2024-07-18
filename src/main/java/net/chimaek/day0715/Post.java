package net.chimaek.day0715;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Post {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createAt; // 언제 만들었냐
}
