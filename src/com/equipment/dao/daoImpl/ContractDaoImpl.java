package com.equipment.dao.daoImpl;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ContractDaoImpl
 */

import com.entity.PageBean;
import com.equipment.dao.ContractDao;
import com.equipment.entity.Contract;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDaoImpl implements ContractDao {

            QueryRunner qr=new QueryRunner();
    @Override
    public List<Contract> findAll() {
       String sql="select * from contract";
        try {
            List<Contract> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Contract.class));
            return list ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addContract(Contract contract) {
       String sql="insert into contract (contract_id,contract_name,first_party,second_party,siging_date,project_location,cost,content," +
               "supply_chain,payment_cycle,acceptance_result) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql,contract.getContractId(), contract.getContractName(), contract.getFirstParty(), contract.getSecondParty(),
                    contract.getSigingDate(), contract.getProjectLocation(), contract.getCost(), contract.getContent(), contract.getSupplyChain(), contract.getPaymentCycle(), contract.getAcceptanceResult());
       return i ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateContract(Contract contract) {
      String sql=" update contract set contract_id=? , contract_name=? ,first_party=? , second_party=? , siging_date=? , project_location=? , " +
              " cost=? , content=? , supply_chain=?, payment_cycle=?, acceptance_result=?  where id=? " ;
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql , contract.getContractId(), contract.getContractName(), contract.getFirstParty(), contract.getSecondParty(),
                    contract.getSigingDate(), contract.getProjectLocation(), contract.getCost(), contract.getContent(), contract.getSupplyChain(), contract.getPaymentCycle(), contract.getAcceptanceResult(),contract.getId());
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteContract(int id) {
        String sql="delete from contract where id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, id );
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Contract> queryPage(PageBean pageBean) {
       String sql="select * from contract order by siging_date desc limit ?,? ";
       List<Contract> list=new ArrayList<>();
        try {
              list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Contract.class), pageBean.getIndex(), pageBean.getPageCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Contract findContractById(int id) {
        String sql="select * from contract where id=? ";
        Contract contract=new Contract();
        try {
              contract = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Contract.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }
}
