package ru.brakhin.workplace.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.brakhin.workplace.model.Request;

import java.util.List;

public interface IRequestRepository extends CrudRepository<Request, Integer> {

    @Query(value = "select r.id, s.name, date(r.req_date) req_date, p.lastname || ' ' || p.name || ' ' || p.pat fio, "
            + "case when coalesce(terminated, false) = true then 'Закрыта' else 'Активна' end state "
            + "from request r, passport p, service s "
            + "where r.id_service = s.id and r.id_passport = p.id and p.lastname || ' ' || p.name || ' ' || p.pat "
            + "like :filter order by :orderIndex",
            nativeQuery = true)
    List<Object> findByFioAndSortBy(@Param("filter") String filter, @Param("orderIndex") Integer orderIndex);

    @Query(value = "select r.id, s.name, date(r.req_date) req_date, p.lastname || ' ' || p.name || ' ' || p.pat fio, "
            + "case when coalesce(terminated, false) = true then 'Закрыта' else 'Активна' end state "
            + "from request r, passport p, service s "
            + "where r.id_service = s.id and r.id_passport = p.id and to_char(req_date, 'YYYY-MM-DD') = :filter "
            + "order by :orderIndex",
            nativeQuery = true)
    List<Object> findByDateAndSortBy(@Param("filter") String filter, @Param("orderIndex") Integer orderIndex);

    @Query(value = "select r.id, s.name, date(r.req_date) req_date, p.lastname || ' ' || p.name || ' ' || p.pat fio, "
            + "case when coalesce(terminated, false) = true then 'Закрыта' else 'Активна' end state "
            + "from request r, passport p, service s "
            + "where r.id_service = s.id and r.id_passport = p.id and "
            + "coalesce(terminated, false) = :filter "
            + "order by :orderIndex",
            nativeQuery = true)
    List<Object> findByStateAndSortBy(@Param("filter") Boolean filter, @Param("orderIndex") Integer orderIndex);

    @Query(value = "select r.id, s.name, date(r.req_date) req_date, p.lastname || ' ' || p.name || ' ' || p.pat fio, "
            + "case when coalesce(terminated, false) = true then 'Закрыта' else 'Активна' end state "
            + "from request r, passport p, service s "
            + "where r.id_service = s.id and r.id_passport = p.id "
            + "order by :orderIndex",
            nativeQuery = true)
    List<Object> findAllSortBy(@Param("orderIndex") Integer orderIndex);

    @Query(value = "select r.id, s.name, date(r.req_date) req_date, p.lastname || ' ' || p.name || ' ' || p.pat fio, "
            + "case when coalesce(terminated, false) = true then 'Закрыта' else 'Активна' end state "
            + "from request r, passport p, service s "
            + "where r.id_service = s.id and r.id_passport = p.id and "
            + "s.name = :filter "
            + "order by :orderIndex",
            nativeQuery = true)
    List<Object> findByServiceAndSortBy(@Param("filter") String filter, @Param("orderIndex") Integer orderIndex);

    Request findById(Long id);
}
