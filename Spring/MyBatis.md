## MyBatis

- SQL Mapping Framework - Easy & Simple
- 자바 코드로부터 SQL문을 분리해서 관리
- 매개변수 설정과 쿼리 결과를 읽어오는 코드를 제거
- 작성할 코드가 줄어서 생산성 향상 & 유지 보수 편리

---

- SqlSessionFactory - SqlSession을 생성해서 제공
- SqlSession + SQL명령을 수행하는데 필요한 메서드 제공

- SqlSessionFactoryBean - SqlSessionFactory를 Spring에서 사용하기 위한 빈
- SqlSessionTemplate - SQL명령을 수행하는데 필요한 메서드 제공. thread-safe

```java
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath:mapper/*Mapper.xml"/>
	</bean>

	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactory"/>
	</bean>
```

---

|메서드|설명|
|:---|:---|
|int insert(String statement) <br>int insert(String statement, Object parameter)|insert문을 실행하고, insert된 행의 갯수를 반환|
|int delete(String statement) <br>int delete(String statement, Object parameter)|delete 실행하고, delete된 행의 갯수를 반환|
|int update(String statement) <br>int update(String statement, Object parameter)|update 실행하고, update된 행의 갯수를 반환|
|T selectOne(String statement) <br>T selectOne(String statement, Object parameter)|하나의 행을 반환하는 select에 사용 <br>paramter로 SQL에 binding될 값 제공
|List<E> selectList(String statement) <br>List<E> selectList(String statement, Object parameter)|여러 행을 반환하는 select에 사용 <br>paramter로 SQL에 binding될 값 제공|
|Map<K,V> selectMap(String statement, String keyCol) <br>Map<K,V> selectMap(String statement, String keyCol, Object parameter)|여러 행을 반환하는 select에 사용 <br>keyCol에 Map의 Key로 사용할 컬럼 지정|