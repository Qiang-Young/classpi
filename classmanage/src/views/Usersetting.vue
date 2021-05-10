<!--个人信息设置-->
<template>
  <div>
    <el-container>
      <div style="margin: 0 auto;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1);height: 50px">
        <el-breadcrumb separator="">
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 15px">
            <i @click="drawer = true" class="el-icon-s-operation"></i>
            <el-drawer
                title="我是标题"
                :visible.sync="drawer"
                :direction="ltr"
                :with-header="false">
              <span>我来啦!</span>
            </el-drawer>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 23px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">我的课堂</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">></a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a style="font-size: medium;font-weight: bold">用户设置</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <i class="el-icon-sort" style="color: black;margin-left: 1200px" ></i>
            <a href="https://v4.ketangpai.com/" style="margin-left: 0px;font-weight: inherit" target="_blank" >切换旧版本</a>
            <i class="el-icon-message-solid" style="color: #303133"></i>
          </el-breadcrumb-item>
          <el-dropdown trigger="click">
            <img src="../assets/class/tou.png" width="32px" height="32px" style="margin-top: 10px">
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item icon="el-icon-arrow-down">开通vip</el-dropdown-item>
              <el-dropdown-item icon="el-icon-paperclip">机构用户认证</el-dropdown-item>
              <el-dropdown-item icon="el-icon-setting">
                <span >个人设置</span></el-dropdown-item>
              <el-dropdown-item icon="el-icon-setting">学术存证</el-dropdown-item>
              <el-dropdown-item icon="el-icon-close">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-breadcrumb>
      </div>
    </el-container>
    <div style="margin-top: 20px">
      <el-container>
        <div style="margin: 0 auto;background-color: #F2F6FC;width: 900px;height: 140px;border-radius: 8px">
          <el-row gutter="">
            <el-col span="3" style="margin-top: 20px;margin-left: 20px">
              <div>
                <img src="../assets/class/tou.png" height="93px" width="93px">
              </div>
            </el-col>
            <el-col span="4">
              <div style="margin-top: 20px">
                <span style="font-size: 25px">杨强</span>
              </div>
              <div style="margin-top: 10px">
                <span style="font-size: 15px;color: dodgerblue">开通课堂派vip</span>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-container>
      <div style="width: 900px;margin: 0 auto;margin-top: 10px">
        <el-container>
          <div style="width: 900px">
            <el-tabs>
              <el-tab-pane label="用户管理" name="first">账户信息</el-tab-pane>
              <el-tab-pane label="配置管理" name="second">通知设置</el-tab-pane>
            </el-tabs>
          </div>
        </el-container>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return{
      userId: '',
      drawer: false,
    }
  },
  methods:{
    tomyclass(){
      this.$router.push({
        path: '/Class',
        query: {
          userId: this.userId
        }
      })
    }
  },
  created() {
    this.$parent.success = false;
    this.userId = this.$route.query.userId
  }
}
</script>
<style scoped>

</style>