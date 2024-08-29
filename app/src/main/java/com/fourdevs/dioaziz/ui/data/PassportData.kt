package com.fourdevs.dioaziz.ui.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passport_data")
data class PassportData(
    @PrimaryKey
    @ColumnInfo(name = "enroll_id") val enrollId: String,
    @ColumnInfo(name = "applicant_name") val applicantName: String,
    @ColumnInfo(name = "father_name") val father: String,
    @ColumnInfo(name = "mother_name") val mother: String,
    @ColumnInfo(name = "pvr_no") val pvrNo: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "end_date") val endDate: String,
    @ColumnInfo(name = "nid_brc_no") val nidBrcNo: String,
    @ColumnInfo(name = "date_of_birth") val dob: String,
    @ColumnInfo(name = "occupation") val occupation: String,
    @ColumnInfo(name = "permanent_address") val permanentAddress: String,
    @ColumnInfo(name = "permanent_post") val permanentPost: String,
    @ColumnInfo(name = "permanent_thana") val permanentThana: String,
    @ColumnInfo(name = "permanent_zilla") val permanentZilla: String,
    @ColumnInfo(name = "present_address") val presentAddress: String,
    @ColumnInfo(name = "present_post") val presentPost: String,
    @ColumnInfo(name = "present_thana") val presentThana: String,
    @ColumnInfo(name = "present_zilla") val presentZilla: String,
    @ColumnInfo(name = "applicant_mobile_no") val applicantMobileNo: String,
    @ColumnInfo(name = "person_one_name") val personOneName: String,
    @ColumnInfo(name = "person_one_relation") val personOneRelation: String,
    @ColumnInfo(name = "person_one_mobile_no") val personOneMobileNo: String,
    @ColumnInfo(name = "person_two_name") val personTwoName: String,
    @ColumnInfo(name = "person_two_relation") val personTwoRelation: String,
    @ColumnInfo(name = "person_two_mobile_no") val personTwoMobileNo: String,
    @ColumnInfo(name = "file_name") val fileName: String? = null,
)