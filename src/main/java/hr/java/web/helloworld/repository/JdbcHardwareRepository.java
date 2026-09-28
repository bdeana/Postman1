package hr.java.web.helloworld.repository;

import hr.java.web.helloworld.domain.Hardware;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JdbcHardwareRepository implements HardwareRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHardwareRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hardware> getAllHardwares() {

        String sql = """
                SELECT h.id, h.naziv, h.cijena, t.naziv AS tip, h.sifra, h.kolicina
                FROM Hardware h
                JOIN Type t ON h.tip_id = t.id
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Hardware(
                        rs.getLong("id"),
                        rs.getString("naziv"),
                        rs.getInt("cijena"),
                        rs.getString("tip"),
                        rs.getInt("sifra"),
                        rs.getInt("kolicina")
                )
        );
    }

    @Override
    public List<Hardware> getHardwaresBySifra(Integer sifra) {

        String sql = """
                SELECT h.id, h.naziv, h.cijena, t.naziv AS tip, h.sifra, h.kolicina
                FROM Hardware h
                JOIN Type t ON h.tip_id = t.id
                WHERE h.sifra = ?
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Hardware(
                                rs.getLong("id"),
                                rs.getString("naziv"),
                                rs.getInt("cijena"),
                                rs.getString("tip"),
                                rs.getInt("sifra"),
                                rs.getInt("kolicina")
                        ),
                sifra
        );
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardware, Integer id) {

        String sql = """
                UPDATE Hardware
                SET naziv = ?,
                    cijena = ?,
                    tip_id = (SELECT id FROM Type WHERE naziv = ?)
                WHERE id = ?
                """;

        int updatedRows = jdbcTemplate.update(
                sql,
                hardware.getNaziv(),
                hardware.getCijena(),
                hardware.getTip(),
                id
        );

        if (updatedRows == 0) {
            return Optional.empty();
        }

        String selectSql = """
                SELECT h.id, h.naziv, h.cijena, t.naziv AS tip, h.sifra, h.kolicina
                FROM Hardware h
                JOIN Type t ON h.tip_id = t.id
                WHERE h.id = ?
                """;

        return jdbcTemplate.query(
                selectSql,
                (rs, rowNum) ->
                        new Hardware(
                                rs.getLong("id"),
                                rs.getString("naziv"),
                                rs.getInt("cijena"),
                                rs.getString("tip"),
                                rs.getInt("sifra"),
                                rs.getInt("kolicina")
                        ),
                id
        ).stream().findFirst();
    }

    @Override
    public boolean hardwareByIdExists(Integer id) {

        String sql = """
                SELECT COUNT(*)
                FROM Hardware
                WHERE id = ?
                """;

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                id
        );

        return count != null && count > 0;
    }

    @Override
    public Integer saveNewHardware(Hardware hardware) {

        String sql = """
                INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
                VALUES (
                    ?,
                    ?,
                    (SELECT id FROM Type WHERE naziv = ?),
                    ?,
                    ?
                )
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, hardware.getNaziv());
            ps.setInt(2, hardware.getCijena());
            ps.setString(3, hardware.getTip());
            ps.setInt(4, hardware.getSifra());
            ps.setInt(5, hardware.getKolicina());

            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean deleteHardwareById(Integer id) {

        String sql = """
                DELETE FROM Hardware
                WHERE id = ?
                """;

        return jdbcTemplate.update(sql, id) > 0;
    }
}