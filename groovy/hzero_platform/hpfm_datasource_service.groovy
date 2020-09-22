package script.db

databaseChangeLog(logicalFilePath: 'script/db/hpfm_datasource_service.groovy') {
    changeSet(author: "hzero@hand-china.com", id: "2019-03-01-hpfm_datasource_service") {
        def weight = 1
        if(helper.isSqlServer()){
            weight = 2
        } else if(helper.isOracle()){
            weight = 3
        }
        if(helper.dbType().isSupportSequence()){
            createSequence(sequenceName: 'hpfm_datasource_service_s', startValue:"1")
        }
        createTable(tableName: "hpfm_datasource_service", remarks: "") {
            column(name: "datasource_service_id", type: "bigint", autoIncrement: true ,   remarks: "")  {constraints(primaryKey: true)} 
            column(name: "service_name", type: "varchar(" + 128 * weight + ")",  remarks: "")  {constraints(nullable:"false")}  
            column(name: "datasource_id", type: "bigint",  remarks: "")  {constraints(nullable:"false")}  
            column(name: "object_version_number", type: "bigint",   defaultValue:"1",   remarks: "")  {constraints(nullable:"false")}  
            column(name: "creation_date", type: "datetime",   defaultValueComputed:"CURRENT_TIMESTAMP",   remarks: "")  {constraints(nullable:"false")}  
            column(name: "created_by", type: "bigint",   defaultValue:"-1",   remarks: "")  {constraints(nullable:"false")}  
            column(name: "last_updated_by", type: "bigint",   defaultValue:"-1",   remarks: "")  {constraints(nullable:"false")}  
            column(name: "last_update_date", type: "datetime",   defaultValueComputed:"CURRENT_TIMESTAMP",   remarks: "")  {constraints(nullable:"false")}  

        }

    }
    changeSet(author: "hzero@hand-china.com", id: "2020-06-11-hpfm_datasource_service") {
        addColumn(tableName: 'hpfm_datasource_service') {
            column(name: "tenant_id", type: "bigint", defaultValue: "0", remarks: "租户ID,hpfm_tenant.tenant_id") {
                constraints(nullable: "false")
            }
        }
    }
}