package copycom.bd.test;

import copycom.bd.dao.NewsDao;
import copycom.bd.dao.impl.NewsDaoMysqlImpl;
import copycom.bd.entity.News;

import java.util.List;

public class test {
    public static void main(String[] args) {
        NewsDao dao = new NewsDaoMysqlImpl();
        List<News> lists = dao.getAll();
        for (News entity : lists){
            System.out.println(entity.getNewsID()+","+entity.getTitle()+","+entity.getContent());
        }
    }
}
