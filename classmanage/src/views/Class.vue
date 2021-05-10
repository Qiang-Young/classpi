<!--我选择的所有课程-->
<template>
  <div>
    <el-container style="text-align: center">
      <div style="margin: 0 auto">
        <el-menu v-show="classbegin" mode="horizontal" default-active="7" style="width: 100%" router>
          <el-menu-item>
            <img :src="logo1Url" idenxheight="50px" width="125" style="text-align: left" @click="tohome"/>
          </el-menu-item>
          <el-menu-item index="7" style="margin-left: 600px" @click="myclass">我的课堂</el-menu-item>
          <el-menu-item index="8" @click="lunwen">论文管理</el-menu-item>
          <el-menu-item >
            <i class="el-icon-sort" style="color: black;margin-left: 500px" ></i>
            <a href="https://v4.ketangpai.com/" style="margin-left: 0px" target="_blank" >切换旧版本</a>
            <i class="el-icon-message-solid" style="color: #303133"></i>
<!--            <el-avatar icon="el-icon-user-solid"></el-avatar>-->

            <el-dropdown trigger="click">
              <img src="../assets/class/tou.png" width="32px" height="32px">
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-arrow-down">开通vip</el-dropdown-item>
                <el-dropdown-item icon="el-icon-paperclip">机构用户认证</el-dropdown-item>
                <el-dropdown-item icon="el-icon-setting">
                  <span @click="tosetting">个人设置</span></el-dropdown-item>
                <el-dropdown-item icon="el-icon-setting">学术存证</el-dropdown-item>
                <el-dropdown-item icon="el-icon-close">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>

          </el-menu-item >

        </el-menu>
<!--        置顶课程-->
        <div style="border-radius: 2px;width: 1150px;margin-top: 20px">
          <el-button type="primary"  style="margin-left: 80%" @click="joinclass">+加入课程</el-button>

        </div>

        <div style="margin: 0 auto;width: 1150px">
          <el-menu v-show="true" class="el-menu-demo"  mode="horizontal" default-active="9">
            <el-menu-item index="9">我学的</el-menu-item>
            <el-button type="primary" style="margin-top: 20px;margin-left: 600px" plain>归档管理</el-button>
            <el-input v-model="search"  placeholder="搜索我学的课程" style="margin-top: 5px;width: 200px;border-radius: 30px;margin-left: 50px"/>
            <el-button class="el-icon-search" @click="searchclass"></el-button>
          </el-menu>
        </div>
<!--        所有课程-->
        <div v-if="this.searchlist.length == 0" style="width: 1150px;margin: 0 auto;margin-top: 10px">
          <el-collapse v-model="activityName">
            <el-collapse-item  title="我的所有课程" name="1" >
              <div >
                <el-row :gutter="20" align="center" style="margin-left: 0">
                  <el-col v-for="(item,key) in userclass.classnum" :span="1" style="height: 310px;width: 259px;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1)" >
                    <div @click="tooneclass(classinformation[key].classnum)" :style="backimg((key)%3)" style="height: 150px;border-radius: 10px 10px 0px 0px;text-align: left">
                      <div style="margin-left: 15px">
                        <span style="color: darkgray;font-size: 5px">{{classinformation[key].classtime}}</span>
                      </div>
                      <div style="margin-top: 10px;margin-left: 15px">
                        <span style="color: beige;font-size: 20px">{{classinformation[key].classname}}</span>
                      </div>
                      <div style="margin-left: 20px;margin-top: 20px">
                        <img src="../assets/class/ma.svg" width="13" height="13" >
                        <span style="color: beige">课堂码:</span>
                        <span style="color: beige">{{classinformation[key].classnum}}</span>
                      </div>
                    </div>
                    <div style="border-radius: 2px;text-align: left;height: 80px">
                      <div style="margin-left: 25px;margin-top: 10px">
                        <span style="font-size: 15px">近期作业</span>
                      </div>
                      <div v-for="count in 2" style="margin-top: 5px;margin-left: 25px">
                        <span style="font-size: 14px;color: #303133;font-weight: 100">{{classinformation[key].assignment[count-1]}}</span>
                      </div>
<!--                      <div style="margin-top: 5px;margin-left: 25px">-->
<!--                        <span style="font-size: 14px;color: #303133;font-weight: 100">7 校验</span>-->
<!--                      </div>-->
                      <div style="height: 10px;margin-top: 0px">
                        <el-divider></el-divider>
                      </div>

                      <div>
                        <span>负责人:</span>
                        <span>{{classinformation[key].manager}}</span>
                        <img style="margin-left: 80px" src="../assets/class/top.svg" width="12" height="12">
                        <span style="margin-left: 5px">置顶</span>
                        <el-dropdown >
                          <img style="margin-left: 10px" src="../assets/class/etc.svg" height="12" width="12">
                          <el-dropdown-menu slot="dropdown" trigger="click">
                            <div>
                              <el-button @click="refundclass(classinformation[key].classnum)" target="_blank" >退课</el-button>
                            </div>
                            <div>
                              <el-button @click="interfile" target="_blank" >归档</el-button>
                            </div>
                          </el-dropdown-menu>

                        </el-dropdown>
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </div>

            </el-collapse-item>
          </el-collapse>
        </div>
<!--        搜索结果-->
        <div v-if="this.searchlist.length > 0" style="width: 1150px;margin: 0 auto;margin-top: 10px">
          <el-collapse v-model="activityName2">
            <el-collapse-item  title="搜索结果" name="2" >
              <div >
                <el-row :gutter="20" align="center" style="margin-left: 0">
                  <el-col v-for="(item,key) in this.searchlist" :span="1" style="height: 310px;width: 259px;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1)" >
                    <div @click="tooneclass(item.classnum)" :style="backimg((key)%3)" style="height: 150px;border-radius: 10px 10px 0px 0px;text-align: left">
                      <div style="margin-left: 15px">
                        <span style="color: darkgray;font-size: 5px">{{item.classtime}}</span>
                      </div>
                      <div style="margin-top: 10px;margin-left: 15px">
                        <span style="color: beige;font-size: 20px">{{item.classname}}</span>
                      </div>
                      <div style="margin-left: 20px;margin-top: 20px">
                        <img src="../assets/class/ma.svg" width="13" height="13" >
                        <span style="color: beige">课堂码:</span>
                        <span style="color: beige">{{item.classnum}}</span>
                      </div>
                    </div>
                    <div style="border-radius: 2px;text-align: left;height: 80px">
                      <div style="margin-left: 25px;margin-top: 10px">
                        <span style="font-size: 15px">近期作业</span>
                      </div>
                      <div v-for="count in 2" style="margin-top: 5px;margin-left: 25px">
                        <span style="font-size: 14px;color: #303133;font-weight: 100">{{item.assignment[count-1]}}</span>
                      </div>
                      <!--                      <div style="margin-top: 5px;margin-left: 25px">-->
                      <!--                        <span style="font-size: 14px;color: #303133;font-weight: 100">7 校验</span>-->
                      <!--                      </div>-->
                      <div style="height: 10px;margin-top: 0px">
                        <el-divider></el-divider>
                      </div>

                      <div>
                        <span>负责人:</span>
                        <span>{{item.manager}}</span>
                        <img style="margin-left: 80px" src="../assets/class/top.svg" width="12" height="12">
                        <span style="margin-left: 5px">置顶</span>
                        <el-dropdown >
                          <img style="margin-left: 10px" src="../assets/class/etc.svg" height="12" width="12">
                          <el-dropdown-menu slot="dropdown" trigger="click">
                            <div>
                              <el-button @click="refundclass(item.classnum)" target="_blank" >退课</el-button>
                            </div>
                            <div>
                              <el-button @click="interfile" target="_blank" >归档</el-button>
                            </div>
                          </el-dropdown-menu>

                        </el-dropdown>
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </div>

            </el-collapse-item>
          </el-collapse>
        </div>



      </div>
    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data () {
    return{
      searchresult: '',
      searchlist:[],
      activityName: '1',
      activityName2: '2',
      search: "",
      // 所有课程
      classinformation:[],
      userId:'',
      //用户信息
      userclass:'',
      classLen: '',
      classsum:'',
      classbegin: true,
      logo1Url: require('../assets/homepageimg/logo.png'),
    }
  },
  methods: {
    // 搜索课程
    searchclass(){
      this.searchlist = []
      let search = this.search;
      for (let i = 0;i < this.userclass.classnum.length; i++){
        if (search.length > 0) {
          if (this.classinformation[i].classnum.indexOf(search) != -1 || this.classinformation[i].classname.indexOf(search) != -1) {
            this.searchlist[this.searchlist.length] = this.classinformation[i]
            this.searchresult = "yes"
          }
        } else {
          this.$message({
            type: 'warning',
            message: '请输入关键词搜索'
          });
          break
        }
      }
    },
    backimg(index){
      index = index + 1
      let style = {
        backgroundImage: "url(" + require("../assets/class/" + index + ".jpg") + ")",
        backgroundRepeat: 'no-repeat',
        backgroundSize: '259px 150px'
      }

      return style
    },
    tooneclass(num){
      this.$router.push({
        path: '/Oneclass',
        query: {
          userId: this.userId,
          classnum: num
        }
      })
    },
    tosetting(){
      this.$router.push({
        path: '/Usersetting',
        query: {
          userId: this.userId
        }
      })
    },
    tohome(){
      this.$router.push('/');
      this.$parent.classbegin = false;
      this.$parent.success = true;
    },
    myclass(){
      this.$router.push({
        path: '/Class',
        query: {
          userId: this.userId
        }
      })
    },
    lunwen(){
      this.$router.push({
        path: '/lunwen',
        query: {
          userId: this.userId
        }
      })
    },
    joinclass() {
      this.$prompt('加课码', '加入课程', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /^[a-zA-Z0-9]{5,8}$/,
        inputErrorMessage: '请输入5-8位由字母或者数字组成的课堂号'
      }).then(({ value }) => {
        const _this = this
        axios.get('http://localhost:8181/class/findall').then(function (res){
          _this.classsum = res.data
          let num = 0
          let num2 = 0
          for(let k = 0;k <= _this.classsum.length-1;k++){
            if(value == _this.classsum[k].classnum){
              num = num + 1
              axios.get('http://localhost:8181/users/findById/' + _this.userId).then(function (resp){
                _this.userclass = resp.data
                if(_this.userclass.classnum < 2){
                  _this.userclass.classnum = value
                  axios.put('http://localhost:8181/users/update', _this.userclass).then(function (rsp) {
                  })
                  _this.$message({
                    type: 'success',
                    message: '加入课程成功'
                  });
                  window.location.reload();
                  return
                }
                _this.userclass.classnum = resp.data.classnum.split(',')
                for (let i = 0; i <= _this.userclass.classnum.length-1;i++) {
                  if (value == _this.userclass.classnum[i]) {
                    _this.$message({
                      type: 'warning',
                      message: '您已经加入了该课程'
                    });
                  } else if (value != _this.userclass.classnum[i]) {
                    num2 = num2 + 1
                  }
                }
                if(num2 == _this.userclass.classnum.length) {
                  _this.userclass.classnum[_this.userclass.classnum.length] = value
                  _this.userclass.classnum = _this.userclass.classnum.join(',')
                  axios.put('http://localhost:8181/users/update', _this.userclass).then(function (rsp) {
                  })
                  _this.$message({
                    type: 'success',
                    message: '加入课程成功'
                  });
                  window.location.reload();
                }

              })
            }
            }
          if(num == 0){
            _this.$message({
              type: 'error',
              message: '该课程不存在'
            });
          }
        })

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    },
    refundclass(classnum){
      this.$confirm('您确定退选该课程吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // this.$message({
        //   type: 'success',
        //   message: '退选成功!'
        // });
        for(let i = 0; i <= this.userclass.classnum.length-1;i++){
          if(this.userclass.classnum[i] == classnum) {
            for (let j = 0; j < this.userclass.classnum.length - 1 - i; j++) {
              this.userclass.classnum[i+j] = this.userclass.classnum[i+j+1]
            }
            this.userclass.classnum.length = this.userclass.classnum.length-1
            this.userclass.classnum = this.userclass.classnum.join(',')
            axios.put('http://localhost:8181/users/update', this.userclass).then(function (resp) {
            })
            window.location.reload()
            return
          }
        }

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消退选'
        });
      });
    },
    interfile(){
      this.$message({
        type: 'success',
        message: "归档"
      })
    },
  },

  created() {
    this.$parent.success = false;
    this.$parent.classbegin = true;
    this.userId = this.$route.query.userId
    const _this = this
    axios.get('http://localhost:8181/users/findById/' + _this.userId).then(function (res){
      _this.userclass = res.data

      if(_this.userclass.classnum.length < 2){
        return
      }
      _this.userclass.classnum = res.data.classnum.split(',');
      _this.classLen = res.data.length

      axios.get('http://localhost:8181/class/findall').then(function (resp) {
        _this.classinformation = resp.data
        let num = 0
        for(let i = 0; i <= resp.data.length-1;i++){
          _this.classinformation[i].assignment = resp.data[i].assignment.split(',')
          _this.classinformation[i].assignment[0] = _this.classinformation[i].assignment[_this.classinformation[i].assignment.length-2]
          _this.classinformation[i].assignment[1] = _this.classinformation[i].assignment[_this.classinformation[i].assignment.length-1]
          for(let j = 0;j <= _this.userclass.classnum.length-1;j++){
            if(_this.classinformation[i].classnum == _this.userclass.classnum[j]) {
              _this.classinformation[num] = _this.classinformation[i]
              num = num + 1
              break
            }
          }
        }

      })
    })
  }
}
</script>
<style scoped>

</style>