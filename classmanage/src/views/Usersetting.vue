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
                <span v-if="this.userclass.username.length > 0" style="font-size: 25px">{{this.userclass.username}}</span>
                <span v-if="this.userclass.username.length == 0 || this.userclass.username.length == null" style="font-size: 25px">您还未设置姓名</span>
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
              <el-tab-pane >
                <span slot="label">账户信息</span>
                <div style="margin: 0 auto;background-color: #F2F6FC;width: 900px;border-radius: 8px">
                  <el-container>
                    <div style="margin-top: 20px;margin-left: 20px">
                      <span @click="edit"> 基础信息</span>
                      <a v-if="this.baseflag == 'scan' " style="margin-left: 750px;color: blue" @click="edit" >编辑</a>
                      <el-button v-if="this.baseflag == 'edit' " style="margin-left: 650px" @click="exitedit">取消</el-button>
                      <el-button v-if="this.baseflag == 'edit' " type="primary" @click="save">保存</el-button>
                    </div>
                  </el-container>
                  <el-container >
                    <div style="margin: 0 auto;width: 852px;margin-top: 20px;border-radius: 8px">
                      <div  >
                        <el-divider></el-divider>
                        <span style="width: 100px">姓名</span>
                        <i v-if="(this.userclass.username.length == 0 || this.userclass.username == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.username}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入姓名" style="width: 200px;margin-left: 120px" v-model="editname"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">学号</span>
                        <i v-if="(this.userclass.number.length == 0 || this.userclass.number == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.number}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入学号" style="width: 200px;margin-left: 120px" v-model="editnumber"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">学校</span>
                        <i v-if="(this.userclass.school.length == 0 || this.userclass.school == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.school}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入学校" style="width: 200px;margin-left: 120px" v-model="editschool"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">院系</span>
                        <i v-if="(this.userclass.court.length == 0 || this.userclass.court == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.court}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入院系" style="width: 200px;margin-left: 120px" v-model="editcourt"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">专业</span>
                        <i v-if="(this.userclass.speciality.length == 0 || this.userclass.speciality == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.speciality}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入专业" style="width: 200px;margin-left: 120px" v-model="editspeciality"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">班级</span>
                        <i v-if="(this.userclass.myclasses.length == 0 || this.userclass.myclasses == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.myclasses}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入班级" style="width: 200px;margin-left: 120px" v-model="editmyclasses"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>

                        <span style="width: 100px">年级</span>
                        <i v-if="(this.userclass.grade.length == 0 || this.userclass.grade == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.grade}}</span>
                        <el-select v-if="this.baseflag == 'edit'" v-model="editgrade" style="margin-left: 120px" placeholder="请选择年级">
                          <el-option label="1年级" value="1grade"></el-option>
                          <el-option label="2年级" value="2grade"></el-option>
                          <el-option label="3年级" value="3grade"></el-option>
                          <el-option label="4年级" value="4grade"></el-option>
                          <el-option label="5年级" value="5grade"></el-option>
                          <el-option label="6年级" value="6grade"></el-option>
                        </el-select>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">入学时间</span>
                        <i v-if="(this.userclass.admission.length == 0 || this.userclass.admission == null) && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 90px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 86px;color: #909399">{{this.userclass.admission}}</span>
                        <el-date-picker v-if="this.baseflag == 'edit'" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" v-model="editadmission" style="margin-left: 85px"></el-date-picker>
                        <el-divider></el-divider>
                      </div>
                    </div>
                  </el-container>
                  <el-container>
                    <div style="margin-top: 50px;margin-left: 20px">
                      <span style="color: #303133;font-size: 20px">账号设置</span>
                    </div>
                  </el-container>
                  <el-container>
                    <div style="margin: 0 auto;width: 852px;margin-top: 30px">
                      <div>
                        <el-divider></el-divider>
                        <span style="width: 100px">课堂派账号</span>
                        <i v-if="this.userclass.ktpnum.length == 0" class="el-icon-warning" style="color: #E6A23C;margin-left: 72px">未完善</i>
                        <span style="margin-left: 72px;color: #909399">{{this.userclass.ktpnum}}</span>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">所属角色</span>
                        <i v-if="(this.userclass.role.length == 0 || this.userclass.role == nul) && this.roleedit == false"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.roleedit == false" style="margin-left: 90px;color: #909399">{{this.userclass.role}}</span>
                        <span v-if="this.roleedit == false" @click="editrole" style="color: #303133;font-size: 20px">去设置</span>
                        <el-button v-if="this.roleedit == true">取消</el-button>
                        <el-button v-if="this.roleedit == true" type="primary">确定</el-button>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">手机号</span>
                        <i v-if="this.userclass.phone.length == 0 || this.userclass.phone == null" class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span style="margin-left: 100px;color: #909399">{{this.userclass.phone}}</span>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">密码</span>
                        <span  style="margin-left: 120px;color: #909399">******</span>
                        <el-divider></el-divider>
                      </div>
                    </div>
                  </el-container>

                  <el-container>
                    <div style="margin-top: 50px;margin-left: 20px">
                      <span @click="edit" style="color: #303133;font-size: 20px">第三方账号绑定</span>
                    </div>
                  </el-container>
                  <el-container>
                    <div style="margin: 0 auto;width: 852px;margin-top: 30px;height: 220px;">
                      <div>
                        <el-divider></el-divider>
                        <span style="width: 100px">邮箱绑定</span>
                        <i v-if="this.userclass.email.length == 0 || this.userclass.email == null" class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span style="margin-left: 72px;color: #909399">{{this.userclass.email}}</span>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">微信绑定</span>
                        <i v-if="this.userclass.wechat.length == 0 || this.userclass.wechat == null" class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span style="margin-left: 72px;color: #909399">{{this.userclass.wechat}}</span>
                        <el-divider></el-divider>
                      </div>
                    </div>
                  </el-container>
                </div>
              </el-tab-pane>
              <el-tab-pane >
                <span slot="label">通知管理</span>
                <div style="margin: 0 auto;background-color: #F2F6FC;width: 900px;height: 255px;border-radius: 8px">
                  <el-container>
                    <div style="margin-top: 20px;margin-left: 20px">
                      <span>消息推送</span>
                    </div>
                  </el-container>
                </div>
              </el-tab-pane>
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
      editname: '',
      editnumber: '',
      editschool: '',
      editspeciality: '',
      editmyclasses: '',
      editadmission: '',
      editgrade: '',
      editcourt: '',
      userId: '',
      drawer: false,
      //用户信息
      userclass:'',
      //基础信息状态
      baseflag: "scan",
      roleedit: false,
    }
  },
  methods:{
    exitedit(){

      this.baseflag = "scan"
    },
    save(){
      this.userclass.username = this.editname
      this.userclass.number = this.editnumber
      this.userclass.school = this.editschool
      this.userclass.court = this.editcourt
      this.userclass.speciality = this.editspeciality
      this.userclass.grade = this.editgrade
      this.userclass.myclasses = this.editmyclasses
      this.userclass.admission = this.editadmission
      axios.put('http://localhost:8181/users/update',this.userclass).then(function (resp) {

      })
      this.baseflag = "scan"
    },
    edit(){
      this.editname = this.userclass.username
      this.editnumber = this.userclass.number
      this.editschool = this.userclass.school
      this.editcourt = this.userclass.court
      this.editspeciality = this.userclass.speciality
      this.editgrade = this.userclass.grade
      this.editmyclasses = this.userclass.myclasses
      this.editadmission = this.userclass.admission
      this.baseflag = "edit"
    },
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
    let _this = this
    axios.get('http://localhost:8181/users/findById/' + _this.userId).then(function (res) {
      _this.userclass = res.data
      this.editname = this.userclass.username
      this.editnumber = this.userclass.number
      this.editschool = this.userclass.school
      this.editcourt = this.userclass.court
      this.editspeciality = this.userclass.speciality
      this.editgrade = this.userclass.grade
      this.editmyclasses = this.userclass.myclasses
      this.editadmission = this.userclass.admission
    })
  }
}
</script>
<style scoped>

</style>