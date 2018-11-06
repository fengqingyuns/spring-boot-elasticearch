package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.apache.lucene.queryparser.flexible.standard.builders.AnyQueryNodeBuilder;
import org.apache.lucene.queryparser.flexible.standard.builders.PhraseQueryNodeBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee queryEmployeeById(String any) {
		// TODO Auto-generated method stub
		Employee temp = null;
		//QueryBuilder qb = new AnyQueryNodeBuilder();
	//	Pageable pageable = new QPageRequest(0, 50);
	//	NativeSearchQueryBuilder  builder = new NativeSearchQueryBuilder().withPageable(pageable);
	//	employeeRepository.search(builder);
		//temp = employeeRepository.search(qb);
		// List<String> newIds = stockCheckTaskDetailList
		//		                 .stream().map(StockCheckTaskDetail::getStockCheckDetailId)
		//                       .collect(Collectors.toList());
		//String queryString = "li";
		/*QueryStringQueryBuilder builder = new QueryStringQueryBuilder(any);
		Iterable<Employee> ems = employeeRepository.search(builder);
		List<Employee> datas = new ArrayList<Employee>();
		Iterator<Employee> iterator = ems.iterator();
		while(iterator.hasNext()) {
			datas.add(iterator.next());
		}
		temp = datas.stream().
				filter(employee ->"li".equals(employee.getFirstName()))
				.collect(Collectors.toList())
				.get(0);*/
		return temp;
	}

	@Override
	public void deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
	Optional<Employee> em = employeeRepository.findById(id);
		if(em == null) {
			return;
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public void addEmployee(Employee em) {
		// TODO Auto-generated method stub
		employeeRepository.save(em).setId("1");
	}

	
}
