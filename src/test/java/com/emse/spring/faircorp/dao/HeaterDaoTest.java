package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
@ExtendWith(SpringExtension.class)
@DataJpaTest

public class HeaterDaoTest {


@Autowired
private HeaterDao heaterDao;

@Test
public void shouldFindAHeater() {
        Heater heater = heaterDao.getById(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
}
}

