## Service Layer

![Service_Layer](Service_Layer.png)

---

## TransactionManager

- DAO의 각 메서드는 개별 Connection을 사용
- 같은 Tx내에서 같은 Connection을 사용할 수 있게 관리
- DAO에서 Connection을 얻거나 반환할 때 DataSourceUtils를 사용해야

```java
conn = ds.getConnction();
// ...
try {
    if (conn != null)
    conn.close();
} catch (SQLException e) {
    e.printStackTrace();
}

    ->

conn = DataSourceUtils.getConnection(ds);
// ...
DataSourceUtils.releaseConnection(conn, ds);
```

### TransactionManager로 Transaction 적용하기

```java
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
<tx:annotation-driven/>
```

---

## @Transactional

- AOP를 이용한 핵심 기능과 부가 기능의 분리
- @Transactional은 클래스나 인터페이스에도 붙일 수 있음

---