package jp.co.ugatria.atsuco.dto.condition;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class BaseCondition {

	private static final String limitNum = "20";

    /**　表示するページ番号　*/
    @QueryParam("pageNo")
    @DefaultValue("1")
    private int pageNo = 1;

    /** 全レコード数. */
    private int totalCount;

    /** １ページに表示する最大レコード数. */
    @QueryParam("limit")
    @DefaultValue(limitNum)
    private int limit;

    /** 並び順（0:昇順、1:降順）. */
    @QueryParam("order")
    @DefaultValue("0")
    private int order;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPrev() {
        return pageNo - 1;
    }

    public int getNext() {
        return pageNo + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        // 総数が変わったことにより、現ページが最大ページ以上になった場合は、最大ページにする
        int maxPage = getPageCount();
        if(pageNo>maxPage) pageNo = maxPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getDefaultLimitNum() {
        return limitNum;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * ページング処理において、スキップする行数を返す.
     * @param pageNo 表示するページ番号
     * @param limit 取得する最大件数
     * @return スキップする行数
     */
    public int getOffset() {
        return (Math.max(pageNo, 1) - 1) * limit;
    }

    /**
     * 検索結果の総ページ数を返す.
     * @param totalCount 検索結果総件数
     * @param limit 取得する最大件数
     * @return 総ページ数
     */
    public int getPageCount() {
        if(totalCount==0) return 0;
        int pageCount = totalCount / limit;
        if (totalCount % limit != 0) {
            pageCount++;
        }
        return pageCount;
    }
}
