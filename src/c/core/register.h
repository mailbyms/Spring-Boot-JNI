#ifndef REGISTER_H
#define REGISTER_H

// 生成注册码函数
// 返回值： 1 成功， 0 失败
int generate_register_code(
    const char* app_name, // 程序名称
    int         app_name_length,
    const char* app_version, // 版本
    int         app_version_length,
    const char* windows_guid,
    int         windows_guid_length,
    const char* disk_serial,
    int         disk_serial_length,
    const char* bios_uuid,
    int         bios_uuid_length,
    const char* machine_id,
    int         machine_id_length,
    const char* agent_id, // 代理商ID（接口需求中的"供应商"是笔误，都是代理商）
    int         agent_id_length,
    int         is_periodically, // 是否分期,1 分期， 0 不分期
    int         auth_type,       // 授权类型
    int         auth_period,     // 授权周期
    int         auth_count,      // 授权分期数
    long        auth_time,       // 授权开始时间，或过期时间，时间戳
    char*       register_code    // 输出参数,长度必须大于256，用于接收注册码
);

#endif