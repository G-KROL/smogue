package com.wawcode.smogue.domain.persistence.item.search;

import org.springframework.stereotype.Repository;
import com.wawcode.smogue.domain.persistence.item.Book;
import com.wawcode.smogue.domain.persistence.item.BookSearchRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookSearchRepositoryImpl implements BookSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> searchBooksBySearchCriteria(final List<BookSearchCriteria> params) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Book> query = builder.createQuery(Book.class);
        final Root r = query.from(Book.class);

        Predicate predicate = builder.conjunction();

        for (final BookSearchCriteria param : params) {
            if (param.getOperation().equalsIgnoreCase(">")) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(r.get(param.getKey()), param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase("<")) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(r.get(param.getKey()), param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase(":")) {
                if (r.get(param.getKey()).getJavaType() == String.class) {
                    predicate = builder.and(predicate, builder.like(r.get(param.getKey()), "%" + param.getValue() + "%"));
                } else {
                    predicate = builder.and(predicate, builder.equal(r.get(param.getKey()), param.getValue()));
                }
            }
        }
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }
}
