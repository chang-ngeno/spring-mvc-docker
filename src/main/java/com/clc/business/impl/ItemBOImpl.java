package com.clc.business.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.clc.business.ItemBO;
import com.clc.model.Item;
import com.clc.util.HibernateUtil;

@Service
public class ItemBOImpl implements ItemBO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Item> fetchAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM items I";
		Query query = session.createQuery(hql);
		List<Item> results = query.list();
		session.close();
		return results;
	}

	public Item findOne(Item item) {
		return findById(item.getItemId());
	}

	public Item findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM items I where I.itemId =: item_id";
		Query query = session.createQuery(hql);
		query.setParameter("item_id", id);
		List<Item> results = query.list();
		session.close();
		return results.get(0);
	}

}
