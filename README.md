# DBS_Practice

📖 IDE는 IntelliJ IDEA Community Edition 2020.2.3을 사용하였습니다.

📖 Main 클래스는 selectQE.java와 InsertQE.java, CreateQE에 위치하고 있습니다.

📖 Select를 하고 싶으면 selectQE.java , Insert를 하고 싶으면 InsertQE.java, Create를 하고 싶으면 Create.QE를 실행 시켜 주면 됩니다.

📖 각 클래스에는 예시 sql문을 작성해 놓은 상태 입니다.

📖mysql.auth는 test_tb 스키마를 위한 DB 접속정보 파일입니다.
 Table은 route, schedule, station, via 총 4개를 추가하였고, Primary key와 foreign key는 3 -[a]에서 언급한 바와 같이 설정하였습니다.
 각 Table의 값은 조건에 맞게 임의로 넣었습니다.

📖 select_1 예시 : "(select S.Route_name, S.Day ,S.S_time, S.D_time " +
                        "from schedule as S, route as R " +
                        "where S.S_time > 10 and S.Route_name = R.Route_name and R.S_station = 'Ga' and R.D_station = 'Na')" +
                        "UNION" +
                        "(select c.Route_name, c.Day ,c.S_time, c.D_time " +
                        "from schedule as c,via as V " +
                        "where c.Code = V.Code and (V.Name = 'Ga' or V.Name = 'Na') and V.S_time > 10)";
                        
📖 select_2 예시 : "(select S.Route_name, S.Day ,S.S_time, S.D_time " +
                        "from schedule as S, route as R " +
                        "where S.S_time > 12 and S.Route_name = R.Route_name and R.S_station = 'Ga' and R.D_station = 'Pa')" +
                        "UNION" +
                        "(select c.Route_name, c.Day ,c.S_time, c.D_time " +
                        "from schedule as c,via as V " +
                        "where c.Code = V.Code and (V.Name = 'Ga' or V.Name = 'Pa') and V.S_time > 12)";
                        
📖 select_3 예시 : "(select S.Route_name, S.Day ,S.S_time, S.D_time " +
                        "from schedule as S, route as R " +
                        "where S.S_time > 6 and S.Route_name = R.Route_name and R.S_station = 'Sa' and R.D_station = 'Ah')" +
                        "UNION" +
                        "(select c.Route_name, c.Day ,c.S_time, c.D_time " +
                        "from schedule as c,via as V " +
                        "where c.Code = V.Code and (V.Name = 'Sa' or V.Name = 'Ah') and V.S_time > 6)";
                        
📖 select_4 예시 : "(select S.Route_name, S.Day ,S.S_time, S.D_time " +
                        "from schedule as S, route as R " +
                        "where S.S_time > 4 and S.Route_name = R.Route_name and R.S_station = 'Ka' and R.D_station = 'Pa')" +
                        "UNION" +
                        "(select c.Route_name, c.Day ,c.S_time, c.D_time " +
                        "from schedule as c,via as V " +
                        "where c.Code = V.Code and (V.Name = 'Ka' or V.Name = 'Pa') and V.S_time > 4)";
                        
📖 select_5 예시 :"(select S.Route_name, S.Day ,S.S_time, S.D_time " +
                "from schedule as S, route as R " +
                "where S.S_time > 11.30 and S.Route_name = R.Route_name and R.S_station = 'Ga' and R.D_station = 'Da')" +
                "UNION" +
                "(select c.Route_name, c.Day ,c.S_time, c.D_time " +
                "from schedule as c,via as V " +
                "where c.Code = V.Code and (V.Name = 'Ga' or V.Name = 'Da') and V.S_time > 11.30)";
