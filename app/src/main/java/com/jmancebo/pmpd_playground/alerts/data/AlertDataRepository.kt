package com.jmancebo.pmpd_playground.alerts.data

import com.jmancebo.pmpd_playground.alerts.domain.AlertModel
import com.jmancebo.pmpd_playground.alerts.domain.AlertRepository

class AlertDataRepository(): AlertRepository {

    override fun getAlerts(): List<AlertModel> {
        return mutableListOf(
            AlertModel(
                "1",
                "Título del primer alertmodel",
                1,
                "Summary del primer alertmodel",
                "04/11/2022",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis aliquet lorem a metus aliquam, faucibus fermentum massa condimentum. Vivamus erat tellus, rhoncus et iaculis sed, condimentum quis augue. Aliquam erat volutpat. Duis venenatis sit amet velit quis egestas. Sed non diam scelerisque, ullamcorper augue nec, pellentesque nulla. Suspendisse porttitor at sapien varius facilisis. In mollis augue id sem laoreet rhoncus. Pellentesque aliquet pretium risus vel maximus.",
                "Source del primer alertmodel",
                mutableListOf()
            )
        )
    }


}