package com.equipment.dao.daoImpl;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ContractDaoImpl
 */

import com.equipment.dao.ContractDao;
import com.equipment.entity.Contract;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ContractDaoImpl implements ContractDao {

            QueryRunner qr=new QueryRunner();
    @Override
    public List<Contract> findAll() {
       String sql="select * from contract";
        try {
            List<Contract> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Contract>(Contract.class));
            return list ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addContract(Contract contract) {
       String sql="insert into contract (contract_name,first_party,second_party,siging_date,project_location,cost,content," +
               "supply_chain,payment_cycle,acceptance_result) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, contract.getContractName(), contract.getFirstParty(), contract.getSecondParty(),
                    contract.getSigingDate(), contract.getProjectLocation(), contract.getCost(), contract.getContent(), contract.getSupplyChain(), contract.getPaymentCycle(), contract.getAcceptanceResult());
       return i ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateContract(Contract contract) {
      String sql="update contract set ( contract_name=? ,first_party=? , second_party=? , siging_date=? , project_location=? , cost=? , content=?," +
              " supply_chain=? , payment_cycle=? , acceptance_result=? )";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, contract.getContractName(), contract.getFirstParty(), contract.getSecondParty(),
                    contract.getSigingDate(), contract.getProjectLocation(), contract.getCost(), contract.getContent(), contract.getSupplyChain(), contract.getPaymentCycle(), contract.getAcceptanceResult());
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteContract(int contractId) {
        String sql="delete from contract where contractId=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, contractId);
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
