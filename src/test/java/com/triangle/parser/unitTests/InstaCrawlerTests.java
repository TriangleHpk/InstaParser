package com.triangle.parser.unitTests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.triangle.parser.models.Post;
import com.triangle.parser.services.InstaCrawler;

@RunWith(MockitoJUnitRunner.class)
public class InstaCrawlerTests {

	private InstaCrawler crawler = new InstaCrawler();

	@Test
	public void crawlerParseTest() throws IOException {
		String jsonString = new String(
				Files.readAllBytes(Paths.get("sss.txt")));
		List<Post> posts = crawler.parse(jsonString, 1);
		Post p = new Post();
		p.setInstaId("1868074036422377544");
		p.setDate(LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong("1536911800")),
				TimeZone.getDefault().toZoneId()));
		p.setLikesCount(0);
		p.setShortCode("Bnsu3BLFgBI");
		p.setImageUrl(
				"https://scontent-frx5-1.cdninstagram.com/vp/9ea5593db4f599d57c9c0a9d823c716a/5C315746/t51.2885-15/e35/40813916_164708631077161_6066922532035433388_n.jpg");
		assertEquals(p.getInstaId(), posts.get(0).getInstaId());
		assertEquals(p.getDate(), posts.get(0).getDate());
		assertEquals(p.getLikesCount(), posts.get(0).getLikesCount());
		assertEquals(p.getShortCode(), posts.get(0).getShortCode());
		assertEquals(p.getImageUrl(), posts.get(0).getImageUrl());
	}
}
