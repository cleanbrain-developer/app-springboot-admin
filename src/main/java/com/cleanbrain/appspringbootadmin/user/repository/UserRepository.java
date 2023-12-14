package com.cleanbrain.appspringbootadmin.user.repository;

import com.cleanbrain.appspringbootadmin.user.model.AppUser;
import com.cleanbrain.appspringbootadmin.user.model.QAppUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-14
 * Comments: 사용자 Repository
 * </pre>
 */
@Repository
public class UserRepository {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;
    private final QAppUser qAppUser = new QAppUser(QAppUser.appUser);

    public UserRepository(EntityManager em) {
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Transactional
    public void create(AppUser appUser) {
        this.em.persist(appUser);
    }

    public AppUser read(long id) {
        return this.jpaQueryFactory.selectFrom(qAppUser)
                .where(qAppUser.id.eq(id))
                .fetchOne();
    }

    @Transactional
    public void update(AppUser updatedAppUser) {
        AppUser originAppUser = this.read(updatedAppUser.getId());
        if (!originAppUser.equals(updatedAppUser)) {
            this.jpaQueryFactory.update(qAppUser)
                    .set(qAppUser, updatedAppUser)
                    .where(qAppUser.id.eq(updatedAppUser.getId()))
                    .execute();
        }
    }

    @Transactional
    public void delete(long id) {
        this.jpaQueryFactory.delete(qAppUser)
                .where(qAppUser.id.eq(id))
                .execute();
    }
}
