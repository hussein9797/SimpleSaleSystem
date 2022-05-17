package Maids.cc.example.Hussein.Yousef.repositories;

import Maids.cc.example.Hussein.Yousef.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
