package net.atos.sample.feign.basic;

import java.util.List;

import feign.*;

public interface GitHub {
	@RequestLine("GET /repos/{owner}/{repo}/contributors")
	List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

	@RequestLine("POST /repos/{owner}/{repo}/issues")
	void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);
}
