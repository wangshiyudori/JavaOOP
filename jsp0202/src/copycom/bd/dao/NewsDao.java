package copycom.bd.dao;

import copycom.bd.entity.News;

import java.util.List;

public interface NewsDao {
    List<News> getAll();
    News getById(int newsID);
}
