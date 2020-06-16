package com.bd.test;

import com.bd.dao.NewsDao;
import com.bd.dao.impl.NewsDaoMysqlImpl;
import com.bd.entity.News;

import java.util.List;

public class test {
    public static void main(String[] args) {
        NewsDao dao = new NewsDaoMysqlImpl();

//3、添加一条数据
        News entity = new News(7,"aaa","aaa");
        dao.insert(entity);
        List<News> lists = dao.getAll();
        for (News en : lists){
            System.out.println(en.getNewsID()+","+en.getTitle()+",\t"+en.getContent());
        }

// 4、删除一条数据
//        dao.deleteByID(5);

        //5、修改一条数据
//        News entity = new News(4,"bbb","bbb");
//        dao.update(entity);
//        //遍历表的内容，45共用
//        List<News> lists = dao.getAll();
//        for (News en : lists){
//            System.out.println(en.getNewsID()+","+en.getTitle()+",\t"+en.getContent());
//        }


//2、通过ID查找一条数据
//        News entity = dao.getById(2);
//        System.out.println(entity.getNewsID()+"\t" + entity.getTitle()+","+entity.getContent());

//1、查找全部数据
//        List<News> lists = dao.getAll();
//        for (News entity : lists){
//            System.out.println(entity.getNewsID()+","+entity.getTitle()+","+entity.getContent());
//        }
    }
}
