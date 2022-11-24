package com.miu.realestate.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FavoriteList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String listName;

    @ManyToOne
    User user;

    @OneToMany
    @JoinColumn(name = "favorite_list_id")
    List<Favorite> favorites;
}
