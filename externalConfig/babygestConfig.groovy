dataSource{
    pooled=true
    jmxExport=true
    driverClassName='com.mysql.jdbc.Driver'
    username="root"
    password=""
}

environments{
  development{
      dataSource{
          url= 'jdbc:mysql://localhost/babygestDev?useUnicode=yes&characterEncoding=UTF-8'
          dialect= "org.hibernate.dialect.MySQL5InnoDBDialect"
      }
  }
  test{
      dataSource{
          url= 'jdbc:mysql://localhost/babygestTest?useUnicode=yes&characterEncoding=UTF-8'
          dialect= "org.hibernate.dialect.MySQL5InnoDBDialect"
      }
  }
  production{
      dataSource{
          url= 'jdbc:mysql://localhost/babygestProd?useUnicode=yes&characterEncoding=UTF-8'
          dialect= "org.hibernate.dialect.MySQL5InnoDBDialect"
      }
  }


}
