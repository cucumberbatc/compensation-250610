<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'Order' }" />
        <VerticalNavLink
            :item="{
                title: 'Order',
                to: '/orders',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Inventory' }" />
        <VerticalNavLink
            :item="{
                title: 'Inventory',
                to: '/inventories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'CheckStock',
                to: '/checkStocks',
            }"
        />
    </ul>
</template>
