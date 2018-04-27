drop index ACT_IDX_HI_DEC_INST_ID on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_KEY on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_PI on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_CI on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_ACT on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_ACT_INST on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_TIME on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_TENANT_ID on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_ROOT_ID on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_REQ_ID on ACT_HI_DECINST;
drop index ACT_IDX_HI_DEC_INST_REQ_KEY on ACT_HI_DECINST;

drop index ACT_IDX_HI_DEC_IN_INST on ACT_HI_DEC_IN;
drop index ACT_IDX_HI_DEC_IN_CLAUSE on ACT_HI_DEC_IN;

drop index ACT_IDX_HI_DEC_OUT_INST on ACT_HI_DEC_OUT;
drop index ACT_IDX_HI_DEC_OUT_RULE on ACT_HI_DEC_OUT;

drop table if exists ACT_HI_DECINST;

drop table if exists ACT_HI_DEC_IN;

drop table if exists ACT_HI_DEC_OUT;