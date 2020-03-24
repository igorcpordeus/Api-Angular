package com.example.network.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.network.models.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long>{

}
