package com.inflearn.hello.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.inflearn.hello.domain.Member;

public class JpaMemberRepository implements MemberRepository {
	private final EntityManager entityManager;

	public JpaMemberRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Member save(Member member) {
		entityManager.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member = entityManager.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name).getResultList();
		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		// List<Member> resultList = entityManager.createQuery("select m from Member m",
		// Member.class).getResultList();
		return entityManager.createQuery("select m from Member m", Member.class).getResultList();
	}

	//@Override
	public void clearData() {
		// TODO Auto-generated method stub

	}

}
