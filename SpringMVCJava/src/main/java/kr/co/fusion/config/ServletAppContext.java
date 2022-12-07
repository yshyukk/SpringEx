package kr.co.fusion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring MVC ������Ʈ�� ���õ� ������ �ϴ� Ŭ����
@Configuration
//Controller ������̼��� ���õǾ� �ִ� Ŭ������ Controller�� ����Ѵ�.
@EnableWebMvc
//��ĵ�� ��Ű���� �����Ѵ�.
@ComponentScan("kr.co.fusion.controller")
public class ServletAppContext implements WebMvcConfigurer{
	// Controller�� �޼��尡 ��ȯ�ϴ� jsp�� �̸� �յڿ� ��ο� Ȯ���ڸ� �����ֵ��� �����Ѵ�.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//���ϸ� �� �� �ָ� jsp ����ǵ���
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	//���� ������ ��θ� �����Ѵ�(�̹�����..)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
}
