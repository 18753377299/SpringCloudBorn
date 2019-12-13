package  org.SpringCloudBorn_api.service;

import java.util.List;

import org.SpringCloudBorn_api.entities.Dept;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import feign.hystrix.FallbackFactory;

@Component // 不要忘记添加，不要忘记添加
//@Service
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(long id)
			{
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> list()
			{
				return null;
			}

			@Override
			public boolean add(Dept dept)
			{
				return false;
			}
		};
	}
}
