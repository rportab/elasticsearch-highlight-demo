package com.example.elasticsearchhighlightdemo;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.query.HighlightQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;

import java.util.List;

@SpringBootTest
class ElasticsearchHighlightDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void nativeSearchQueryExample() {
        final var nativeSearchQuery = new NativeSearchQueryBuilder().withHighlightBuilder(new HighlightBuilder()
                .highlightQuery(QueryBuilders.boolQuery()
                        .should(QueryBuilders.matchQuery("field 1", "value 1"))
                        .should(QueryBuilders.matchQuery("field 2", "value 2"))));
        final var ignored = "this allows me to set a breakpoint here";
    }

    @Test
    void nativeQueryExample() {
        final var nativeQuery = new NativeQueryBuilder().withHighlightQuery(new HighlightQuery(new Highlight(List
                .of(new HighlightField("field 1"), new HighlightField("field 2"))), Object.class));
        final var ignored = "this allows me to set a breakpoint here";
    }
}
