package com.javierv.itemsreview.repository;

import com.javierv.itemsreview.model.Item;
import com.javierv.itemsreview.model.Review;
import com.javierv.itemsreview.model.TitleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("SELECT i.title FROM Item AS i")
    List<String> getTitles();

    List<TitleView> findAllByTitle(String title);

    List<TitleView> findAllProjectedBy();

    @Query(value = "SELECT I.ID, I.TITLE\n" +
            "FROM ITEM I\n" +
            "LEFT JOIN REVIEW R\n" +
            "ON I.ID = R.ITEM_ID\n" +
            "GROUP BY I.ID, I.TITLE\n" +
            "HAVING COALESCE(AVG(R.REVIEW), 0) < ?1", nativeQuery = true)
    List<Item> findByAverageRating(Double rating);

    @Query(value = "SELECT new java.lang.String(I.title)\n" +
            "FROM Item I\n" +
            "LEFT JOIN Review R\n" +
            "ON I.id = R.item_id\n" +
            "GROUP BY I.id, I.title\n" +
            "HAVING COALESCE(AVG(R.review), 0) < ?1")
    List<String> findByAverageRating2(Double rating);
}
