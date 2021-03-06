package com.lst.lc.entities;

// Generated 2015-8-23 12:55:26 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RelUserId generated by hbm2java
 */
@Embeddable
public class RelUserId implements java.io.Serializable {

        private int userId1;
        private int userId2;

        public RelUserId() {
        }

        public RelUserId(int userId1, int userId2) {
                this.userId1 = userId1;
                this.userId2 = userId2;
        }

        @Column(name = "userId1", nullable = false)
        public int getUserId1() {
                return this.userId1;
        }

        public void setUserId1(int userId1) {
                this.userId1 = userId1;
        }

        @Column(name = "userId2", nullable = false)
        public int getUserId2() {
                return this.userId2;
        }

        public void setUserId2(int userId2) {
                this.userId2 = userId2;
        }

        public boolean equals(Object other) {
                if ((this == other))
                        return true;
                if ((other == null))
                        return false;
                if (!(other instanceof RelUserId))
                        return false;
                RelUserId castOther = (RelUserId) other;

                return (this.getUserId1() == castOther.getUserId1())
                                && (this.getUserId2() == castOther.getUserId2());
        }

        public int hashCode() {
                int result = 17;

                result = 37 * result + this.getUserId1();
                result = 37 * result + this.getUserId2();
                return result;
        }

}
