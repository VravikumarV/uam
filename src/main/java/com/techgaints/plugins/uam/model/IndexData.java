package com.techgaints.plugins.uam.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IndexData {

    public java.lang.String key;

    public void setKey(String key) {
        this.key = this.index.concat("-").concat(this.getDate()).concat("-").concat(this.getOpen().toString());
    }

    public java.lang.String index;
    /** Index Date */
     public java.lang.String date;
    /** Index Open Value */
     public java.lang.Double open;
    /** Index high value */
     public java.lang.Double high;
    /** Index low value */
     public java.lang.Double low;
    /** Index closing value */
     public java.lang.Double close;
    /** Index adjClose value */
     public java.lang.Double adjClose;
    /** Index volume */
     public java.lang.Long volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexData indexData = (IndexData) o;
        return index.equals(indexData.index) && date.equals(indexData.date) && open.equals(indexData.open) && high.equals(indexData.high) && low.equals(indexData.low) && close.equals(indexData.close);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, date, open, high, low, close);
    }
}
