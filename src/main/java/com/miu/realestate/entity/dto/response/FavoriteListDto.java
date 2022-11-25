package com.miu.realestate.entity.dto.response;
import com.miu.realestate.entity.Favorite;
import com.miu.realestate.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteListDto {
    private Long id;
    private String listName;
    private Long userId;
}
