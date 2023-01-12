## Transaction

- 더 이상 나눌 수 없는 작업의 단위. (Tx - insert, update, select)

- 계좌 이체의 경우, 출금(update)과 입금(update)이 하나의 Tx로 묶여야 됨.
    
    '모' 아니면 '도'. 출금과 입금이 모두 성공하지 않으면 실패

### ACID

- 원자성(**A**tomicity) - 나눌 수 없는 하나의 작업으로 다뤄져야 한다.
- 일관성(**C**onsistency) - Tx 수행 전과 후가 일관된 상태를 유지해야 한다.
- 고립성(**I**solation) - 각 Tx는 독립적으로 수행되어야 한다.
- 영속성(**D**urability) - 성공한 Tx의 결과는 유지되어야 한다.

### isolation level

- READ UNCOMMITED - 커밋되지 않은 데이터도 읽기 가능
- READ COMMITED - 커밋된 데이터만 읽기 가능
- REPEATABLE READ(default) - Tx이 시작된 이후 변경은 무시됨
- SERIALIZABLE - 한번에 하나의 Tx만 독립적으로 수행

---